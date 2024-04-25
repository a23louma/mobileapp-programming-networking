
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
Därefter skapade jag en TextView i "recyclerviewitem" och gav den ett id, "recycler_view_item_title".
se koden nedan.
```
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/recycler_view_item_title"/>
```
Därefter skapade jag en RecyclerViewAdapter i MainActivity. Jag behövde skapa klassen RecyclerViewAdapter.
Se koden nedan.
```
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mountains, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Mountain item) {
                Log.d("Klickat", "mountain");
            }
        });
```
I klassen RecyclerViewAdapter behövde jag extenda klassen med RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>.
Jag implementerade metoderna som behövde implementeras. Jag kopierade koden från Canvas för
RecyclerViewAdapter. I samma fil behövde även klassen ViewHolder skapas. Se koden nedan.
```
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
```

Därefter skapade jag klassen RecyclerViewItem. Se koden nedan.
```
public class RecyclerViewItem {
private String title;

    public RecyclerViewItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
```
Därefter ändrade jag i MainActivity för att ha RecyclerViewItem-objekt i ArrayListen istället för
Mountain-objekt. Se koden nedan.
```
ArrayList<RecyclerViewItem> items = new ArrayList<>(Arrays.asList(new RecyclerViewItem("Kinnekulle"),
new RecyclerViewItem("Billingen"), new RecyclerViewItem("Mösseberg")));

```

Jag ändrade även adaptern i MainActivity för att hantera RecyclerViewItem-objekt istället för
Mountain-objekt.
```
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                Log.d("Klickat", "mountain");
            }
```

I MainActivity lade jag till en RecyclerView och hämtade den med hjälp av findViewById. Jag lade till
adaptern till min view. Se koden nedan.
```
        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
```
Det uppstod ett problem att appen krashade när den startades. Jag insåg att när titeln för ViewHolder
hämtades från recyclerviewitem.xml var det fel ID, efter att detta ändrats fungerade det att starta
appen. Se koden nedan.
```
        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.recycler_view_item_title);
        }
        ```
```
Därefter lade jag in en URL i stringen JSON_URL i MainActivity. Se koden nedan.
```
private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
```
Jag skapade ett Gson-objekt i metoden OnCreate. Därefter ändrade jag i metoden OnPostExecute för att
"unmarshall" json-filen till en lista med objekt. Se koden nedan.
```
    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Type type = new TypeToken<ArrayList<RecyclerViewItem>>() {}.getType();
        ArrayList<RecyclerViewItem> items = gson.fromJson(json, type);
    }
```
Därefter skapade jag metoden updateData för att rensa items och lägga till de nya objekten från
json i RecyclerViewAdapter-klassen. Se koden nedan.
```
    public void updateData(ArrayList<RecyclerViewItem> newMountainsList) {
        items.clear();
        items.addAll(newMountainsList);
        notifyDataSetChanged();
    }
```
Sedan lade jag till metoden toString i RecyclerViewItem för att kunna visa namnen på bergen i
RecyclerView. Se koden nedan.
```
    @Override
    public String toString() {
        return "RecyclerViewItem{" +
                "title='" + title + '\'' +
                '}';
    }
```
Jag fick inte upp bergen på screenen och behövde ändra i RycyclerViewItem och genom att lägga till
koden nedan fungerade det därefter.
```
    @ SerializedName ("name")
    private String title;
```
Bilder läggs i samma mapp som markdown-filen.

![](android.png)

