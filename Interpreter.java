package Project;

public class Interpreter {
    public static class ArithmeticExpression {

        private int token_code = Codes.INT_CODE;
        private String sequence = "0";
        private ArithmeticExpression left = null;
        private ArithmeticExpression right = null;

        public ArithmeticExpression(int code, String seq) {
            this.token_code = code;
            this.sequence = seq;
        }

        public ArithmeticExpression() {
        }

        public void setLeft(ArithmeticExpression new_left) {
            this.left = new_left;
        }

        public void setRight(ArithmeticExpression new_right) {
            this.right = new_right;
        }

        public void setSequence(String seq) {
            this.sequence = seq;
        }

        public void setTokenCode(int code) {
            this.token_code = code;
        }

        public String getSequence() {
            return this.sequence;
        }

        public int getTokenCode() {
            return this.token_code;
        }

        public ArithmeticExpression getLeft() {
            this.left = new ArithmeticExpression();
            return this.left;
        }

        public ArithmeticExpression getRight() {
            this.right = new ArithmeticExpression();
            return this.right;
        }

        public static int eval(ArithmeticExpression ae) {
            int value = 0;
            switch (ae.getTokenCode()) {
                case Codes.ID_CODE:
                    value = Integer.parseInt(ae.getSequence());
                    break;
                case Codes.INT_CODE:
                    value = Integer.parseInt(ae.getSequence());
                    break;
                case Codes.ADD_CODE:
                    value = eval(ae.getLeft()) + eval(ae.getRight());
                    break;
                case Codes.SUB_CODE:
                    value = eval(ae.getLeft()) - eval(ae.getRight());
                    break;
                case Codes.MUL_CODE:
                    value = eval(ae.getLeft()) * eval(ae.getRight());
                    break;
                case Codes.DIV_CODE:
                    value = eval(ae.getLeft()) / eval(ae.getRight());
                    break;
                default:
                    break;
            }
            return value;
        }

    }


    public class BooleanExpression extends ArithmeticExpression {
        private ArithmeticExpression left;
        private ArithmeticExpression right;
        private int op;

        public BooleanExpression(ArithmeticExpression l, int op, ArithmeticExpression r) {
            this.left = l;
            this.right = r;
            this.op = op;
        }

        public ArithmeticExpression getLeft() {
            return this.left;
        }

        public ArithmeticExpression getRight() {
            return this.right;
        }

        public int getOperator() {
            return this.op;
        }

        public boolean evaluate() {
            int left_value = ArithmeticExpression.eval(this.left);
            int right_value = ArithmeticExpression.eval(this.right);
            boolean result = false;

            switch (this.getOperator()) {
                case Codes.EQ_CODE:
                    result = left_value == right_value;
                    break;
                case Codes.LE_CODE:
                    result = left_value <= right_value;
                    break;
                case Codes.LT_CODE:
                    result = left_value < right_value;
                    break;
                case Codes.GE_CODE:
                    result = left_value >= right_value;
                    break;
                case Codes.GT_CODE:
                    result = left_value > right_value;
                    break;
                default:
                    break;
            }

            return result;

        }

    }
}