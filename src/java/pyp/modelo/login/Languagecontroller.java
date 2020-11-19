package pyp.modelo.login;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;

@Named(value = "languagecontroller")
@SessionScoped
public class Languagecontroller implements Serializable {

    private String lang;
    private Locale locale;
    private List<Locale> locales;

    public Languagecontroller() {
    }

    @PostConstruct
    public void init() {
        locales = new ArrayList<>();
        locales.add(new Locale("es"));
        locales.add(new Locale("en"));
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
        locale = new Locale(lang);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public List<Locale> getLocales() {
        return locales;
    }
    

}
