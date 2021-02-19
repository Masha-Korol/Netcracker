package annotation;

import data.Data;
import exception.InjectorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is describing actions for annotation @Inject.
 */
@Configuration(packages = {"sorter", "validator"})
public class Injector {

    /**
     * This method injects in property entity of class, which type is suitable for property type.
     * It injects in property entity of class, which type is suitable for property type.
     * @param o - entity in whose properties we check for annotation
     * @return - entity with injected property (if there wasn't any exceptions)
     * @throws InjectorException - in case property is not list and there's more than one or none suitable classes were found
     * or there're some errors connected with file or class searching or reading
     */
    public static <T> T inject(T o) throws InjectorException {

        Configuration annotation = Injector.class.getAnnotation(Configuration.class);
        String[] packageName = Injector.class.getAnnotation(Configuration.class).packages();

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {

            try {
                if (field.isAnnotationPresent(Inject.class)) {

                    //if(field.getAnnotation(Inject.class).clazz() != void.class){
                    if (field.getGenericType().getTypeName().startsWith("java.util.List<")) {

                        //Type genericType = field.getGenericType();
                        List<Class> classes = getClasses(packageName, field.getAnnotation(Inject.class).clazz());
                        field.setAccessible(true);
                        List<Object> objectList = new ArrayList<Object>();
                        for(Class currentClass : classes){
                            objectList.add(currentClass.newInstance());
                        }
                        field.set(o, objectList);
                    } else {
                        List<Class> classes = getClasses(packageName, field.getType());
                        if (classes.size() > 1) {
                            throw new InjectorException("Больше одного класса найдено");
                        } else if (classes.size() == 0) {
                            throw new InjectorException("Ни одного класса не найдено");
                        }
                        field.setAccessible(true);
                        field.set(o, classes.get(0).newInstance());
                    }
                }
            } catch (ClassNotFoundException | IOException | InstantiationException | IllegalAccessException e) {
                throw new InjectorException(e);
            }
        }
        return o;
    }

    /**
     *
     * @param packageName - name pf the package to look in (gotten from annotation @Configuration)
     * @param clazz - class of property
     * @return - list of all suitable classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static List<Class> getClasses(String[] packageName, Class clazz) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        List classes = new ArrayList();

        for(String currentPackage : packageName){
            String path = currentPackage.replace('.', '/');
            URL resource = classLoader.getResource(path);
            File directory = new File(resource.getFile());
            classes.addAll(findClasses(directory, currentPackage, clazz));
        }

        return classes;
    }

    /**
     * Looks for all files in the given folder and either adds them to list of classes, or,
     * if it's another folder, recursively looks in it too.
     * @param directory - directory in which to look for classes.
     * @param packageName - name of the whole package
     * @param clazz - class of property
     * @return - list pf suitable classes in this folder
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName, Class clazz) throws ClassNotFoundException {

        List classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName(), clazz));
            } else if (file.getName().endsWith(".class")) {
                Class<?> foundClass = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
                if (clazz.isAssignableFrom(foundClass) &&
                        !foundClass.isInterface() &&
                        !Modifier.isAbstract(foundClass.getModifiers())) {
                    classes.add(foundClass);
                }
            }
        }
        return classes;
    }
}
