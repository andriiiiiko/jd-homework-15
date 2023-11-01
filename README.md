# Todo List Project using Spring Boot

This project aims to create a system for managing notes (Todo List) using Spring Boot, gradually adding different 
modules.

The project will consist of a single entity - Note. Users can manage these notes by viewing the list of notes, adding 
new ones, and editing existing ones.

### Task 1 - Create a new Spring Boot project

Create a new Spring Boot project using Gradle as the build system. Omit modules such as Spring MVC, Spring Data, and 
Spring Security for now. These will be added later.

You can use [Spring Boot Initializr](https://start.spring.io/) to create the Spring Boot project.

### Task 2 - Create the Note entity

Create the Note entity with the following fields:

- `id` - a unique identifier, an auto-generated integer.
- `title` - the title of the note, a string.
- `content` - the content of the note, a string.

Since the Spring Data module is not connected to the project yet, do not add the `@Entity` annotation to the entity.

### Task 3 - Create the CRUD service NoteService

Create a new class named `NoteService`. This class manages notes. Initially, the notes will be stored in a collection 
(e.g., `List<Note>` or `Map<Long, Note>`).

The service should include the following methods:

- `List<Note> listAll()` - returns a list of all notes.
- `Note add(Note note)` - adds a new note, generating a unique (random) numerical identifier for the note. It returns 
the same note with the generated identifier.
- `void deleteById(long id)` - deletes the note with the specified identifier. If the note with the given identifier 
does not exist, it throws an exception.
- `void update(Note note)` - searches for the note by `note.id`. If the note exists, it updates its `title` and 
`content`. If the note doesn't exist, it throws an exception.
- `Note getById(long id)` - returns the note based on its identifier. If the note doesn't exist, it throws an exception.

Use the `@Service` annotation to make this class a Spring Bean.

Ensure the program runs without errors when started.

### Task 4 - Upload all the code to a GitHub repository

Upload the code to a GitHub repository. Make sure the `.gitignore` file is set up correctly, and only necessary files 
are included in the repository.
