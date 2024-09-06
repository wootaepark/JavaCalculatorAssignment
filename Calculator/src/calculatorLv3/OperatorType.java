package calculatorLv3;

public enum OperatorType {

    ADD("+"),  // name(label)
    SUB("-"),
    MUL("*"),
    DIV("/");


    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }
    public String getOperator() {
        return operator;
    }
}
