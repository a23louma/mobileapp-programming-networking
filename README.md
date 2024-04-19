
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
Därefter skapade jag en ArrayList "mountains" för att lagra Mountain-objekt i MainActivity.java.
Jag skapade tre Mountain-objekt som lades till i ArrayListen. För att kontrollera att det fungerade
loopade jag igenom mountains med en for-loop och skrev ut attributet "namn" för alla tillagda berg
med hjälp av LogCat.
```
        ArrayList<Mountain> mountains = new ArrayList<>(Arrays.asList(new Mountain("Kinnekulle"),
        new Mountain("Billingen"), new Mountain("Mösseberg")));

        for(int i=0; i<mountains.size(); i++) {
            Log.d("Berg", mountains.get(i).toString());
        }
```
Därefter lade jag till en RecyclerView i activity_main.xml.
```
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
Sedan skapade jag en ny layout-fil och namngav den till "recyclerviewitem". Jag ändrade layout_height.
Se koden nedan.
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

</LinearLayout>
```

Bilder läggs i samma mapp som markdown-filen.

![](android.png)

