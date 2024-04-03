// Design intent:
//      to compose individual objects to build up a tree structure
//      e.g. a folder can contain files and other folders
//
//      the individual objects and the composed objects are treated uniformly
//      e.g. files and folders both have a name

class Component {
    ...
}

class Leaf extends Component{
    int getSize() {
        return size;
    }
}

class Composite extends Component{
    Component[] children;
    int getSize() {
        int size = 0;
        for (int i = 0; i < children.length; i++) {
            size += children[i].getSize();
        }
        return size;
    }
}

