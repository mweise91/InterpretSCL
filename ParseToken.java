package Project;

public class ParseToken {

    private Integer typeCode;
    private Integer parameterCode;
    private Integer literalCode;

    public ParseToken(final Integer typeCode, final Integer parameterCode, final Integer literalCode) {
        this.typeCode = typeCode;
        this.parameterCode = parameterCode;
        this.literalCode = literalCode;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public int getParameterCode() {
        return parameterCode;
    }

    public int getLiteralCode() {
        return literalCode;
    }
}
