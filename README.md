
# Rapport

Jag började med att skapa en Mountain-klass med tre attribut, "namn", "location" och "height".
Jag skapade två constructors, en med bara namn som parameter och en med namn, location och height 
som parametrar. Se koden nedan.
```
    private String name;
    private String location;
    private int height;

    public Mountain(String name, String location, int height) {
        this.name = name;
        this.location = location;
        this.height = height;
    }

    public Mountain(String name) {
        this.name = name;
        location = null;
        height = 0;
    }
```
Därefter skapade jag getters och setters för alla attribut i Mountain-klassen samt lade till metoden
toString som returnerar attributet namn. Se koden nedan.
```
    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                '}';
    }
```

```
```



Bilder läggs i samma mapp som markdown-filen.

![](android.png)

