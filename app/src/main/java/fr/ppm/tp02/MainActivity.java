package fr.ppm.tp02;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private PersonAdapter personAdapter;
    private List<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.persons = createPersons();
        listView = findViewById(R.id.list_view);
        personAdapter = new PersonAdapter(this, R.layout.person_list_item, persons);
        listView.setAdapter(personAdapter);

        // a
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Person person = (Person) parent.getItemAtPosition(position);
            Toast.makeText(MainActivity.this, "Clické en : " + person.getFullName(), Toast.LENGTH_SHORT).show();
        });
    }

    private List<Person> createPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", "Doe", "123-456-7890", "john.doe@example.com"));
        persons.add(new Person("Jane", "Doe", "987-654-3210", "jane.doe@example.com"));
        persons.add(new Person("Bob", "Smith", "555-123-4567", "bob.smith@example.com"));
        persons.add(new Person("Alice", "Johnson", "999-888-7777", "alice.johnson@example.com"));
        persons.add(new Person("David", "Lee", "111-222-3333", "david.lee@example.com"));
        persons.add(new Person("Emily", "Chen", "444-555-6666", "emily.chen@example.com"));
        return persons;
    }
}

