package ge.temo.librarymanagement.model;

public class UserDTO {
    private Long id;
    private String name;

    public UserDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
    }
}
