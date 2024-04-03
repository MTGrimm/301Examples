// model boolean logic expressions with composite pattern
// Leaf: true or false
// Composite(s): expression, || and &&


class Component {
    ...
}

class Leaf extends Component {
    boolean logicType; // true or false
    boolean getLogic() {
        return logicType
    }
}

class Or extends Component {
    Component[] children;
    boolean getLogic() {
        for (int i = 0; i < children.length; i++) {
            if (children.getLogic() == true) {
                return true;
            }
        }
        return false;
    }
}

class And extends Component {
    Component[] children;
    boolean getLogic() {
        for (int i = 0; i < children.length; i++) {
            if (children.getLogic() == true) {
                return false;
            }
        }
        return true;
    }
}

// actual solution
class True extends Expression {
    public boolean evaluate() {
        return true;
    }
}

class False extends Expression {
    public boolean evaluate() {
        return false;
    }
}

class Or extends Expression {
    Expression child1;
    Expression child2;

    public Or(Expression c1, Expression c2) {
        child1 = c1;
        child2 = c2;
    }
    
    public boolean evaluate() {
        return child1.evaluate() || child2.evaluate();
    }
}

class And extends Expression {
    Expression child1;
    Expression child2;

    public And(Expression c1, Expression c2) {
        child1 = c1;
        child2 = c2;
    }
    
    public boolean evaluate() {
        return child1.evaluate() && child2.evaluate();
    }
}
