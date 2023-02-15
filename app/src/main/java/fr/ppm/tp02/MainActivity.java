package fr.ppm.tp02;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        Button addButton = findViewById(R.id.btn_add);
        addButton.setOnClickListener(view -> {
            showAddDialog();
        });
    }

    public void clearList(View view) {
        this.persons.clear();
        this.personAdapter.clear();
        this.personAdapter.notifyDataSetChanged();
        Toast.makeText(this, "List cleared", Toast.LENGTH_SHORT).show();
    }


    private void showAddDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.dialog_add_person, null);

        final EditText nameEditText = dialogView.findViewById(R.id.firstNameText);
        final EditText phoneEditText = dialogView.findViewById(R.id.phoneEditText);
        final EditText emailEditText = dialogView.findViewById(R.id.emailEditText);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setTitle("Ajouter une personne");
        builder.setPositiveButton("Ajouter", (dialog, which) -> {
            String firstName = nameEditText.getText().toString().trim();
            String lastName = nameEditText.getText().toString().trim();
            String phone = phoneEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();

            if (!firstName.isEmpty() && !lastName.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                Person newPerson = new Person(firstName, lastName, phone, email);
                this.personAdapter.add(newPerson);
                Toast.makeText(MainActivity.this, "Personne ajoutée: " + newPerson.getFullName(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Annuler", null);

        AlertDialog dialog = builder.create();
        dialog.show();
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

