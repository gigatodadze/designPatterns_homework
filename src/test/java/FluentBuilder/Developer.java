package FluentBuilder;

import java.util.List;

class Developer {
    private String email;
    private String name;
    private List<String> languages;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<String> getLanguages() {

        return this.languages;
    }

    public void setLanguages(List<String> languages)
    {
        this.languages = languages;
    }
}
