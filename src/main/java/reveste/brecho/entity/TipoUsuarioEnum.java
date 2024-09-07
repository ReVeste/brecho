package reveste.brecho.entity;

public enum TipoUsuarioEnum {
    CLIENTE(1),
    FUNCIONARIO(2),
    ADMIN(3),
    TECNICO(4);

    private Integer codigo;

    private TipoUsuarioEnum(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return this.codigo;
    }
}
