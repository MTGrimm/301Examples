// design intent:
//      ensure a class only has one instance 
//      and provide a global point of access to it
//      e.g. databases, preferences
// Singleton Example Code 1
public class ExampleSingleton {
    ...
    // on class creation creates a private instance of the class
    private static final ExampleSingleton instance = new ExampleSingleton();
    
    // private constructor
    // so only this class itself can call new
    // and other classes cannot make another instance
    private ExampleSingleton() {
        ...
    }

    // use ExampleSingleton.getInstance() to access
    public static ExampleSingleton getInstance() {
        return instance;
    }
    ...
}

// not good because it creates the instance at start which can be a problem
// if its a large class and we don't want to take up all that memory
// at the start of the program when we don't need it

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//

// Singleton Example Code 2
public class ExampleSingleton {
    ...
    // nested class is loaded and singleton instance 
    // created on first call to getInstance()
    private static class ExampleSingletonHolder {
        private static final ExampleSingleton instance = new ExampleSingleton();
    }

    // private constructor
    // so only this class itself can call new
    // and other classes cannot make another instance
    private ExampleSingleton() {
        ...
    }

    // use ExampleSingleton.getInstance() to access
    public static ExampleSingleton getInstance() {
        return ExampleSingletonHolder.instance;
    }
    ...
}
// not good because we are abusing java or something (deserved)
// isn't gauranteed to work or something or whatever

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
// Singleton Example Code 3 (lazy construction)
public class ExampleSingleton {
    ...
    // on class creation creates a private instance of the class
    private static ExampleSingleton instance = null;
    
    // protected constructor makes it possible
    // to create instances of subclasses so we can
    // create mockclasses
    protected ExampleSingleton() {
        ...
    }

    // use ExampleSingleton.getInstance() to access
    // lazy construction of the instance
    public static ExampleSingleton getInstance() {
        if (instance == null) {
            instance = new ExampleSingleton();
        }
        return instance;
    }
    ...
}


