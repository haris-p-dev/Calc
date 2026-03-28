# Calculator API

Το project ζητάει μέσα από τα παρακάτω endpoints:

1.  **Addition**: `GET /calc/add?a=5&b=3`  
2.  **Subtraction**: `GET /calc/sub?a=10&b=4`  
3.  **Get Memory**: `GET /calc/memory`  
4.  **Clear Memory**: `POST /calc/memory/clear`  

να γίνουν οι αντίστοιχες πράξεις.

-   Endpoint `/calc/add?a=5&b=3` μετά από GET request επιστρέφει  
    αποτέλεσμα πρόσθεσης.  
-   Endpoint `/calc/sub?a=3&b=3` μετά από GET request επιστρέφει  
    αποτέλεσμα αφαίρεσης.  
-   Endpoint `/calc/memory`, έχοντας υλοποίηση αποθήκευσης στο service,  
    επιστρέφει το τελευταίο αποτέλεσμα οποιασδήποτε από τις παραπάνω  
    πράξεις.  
-   Endpoint `/calc/memory/clear` καθαρίζει αυτή τη μνήμη (POST).

## Δομή Project

Το project χωρίζεται σε 3 μέρη:

-   Το `DemoApplication`, που είναι η έναρξη του project.  
-   Στον φάκελο **Controllers**, που περιέχει το αρχείο  
    `CalculatorController`.  
-   Στον φάκελο **Services**, που περιέχει το αρχείο `AppServices`.

## Service Layer

Το `AppServices` περιέχει όλη τη λογική του API.

Έχει δημιουργηθεί μεταβλητή τύπου `Double`. Για να μπορεί να αποθηκευτεί και να επιστραφεί η μεταβλητή με value `null`,  
η χρήση wrapper class είναι υποχρεωτική.

### Μέθοδοι

1.  **lastResult()**  
    Επιστρέφει την τιμή της μεταβλητής `result`. Αν αυτή είναι `null`, επιστρέφεται `null`.  
    Η διαχείριση του HTTP status γίνεται στον controller στη μέθοδο `memory()` για το endpoint  
    `/calc/memory`.

2.  **addition(Double a, Double b)**  
    Δίνει το αποτέλεσμα της πρόσθεσης `a + b` στη μεταβλητή `result` και επιστρέφει το αποτέλεσμα.  
    Καλείται στον controller στη μέθοδο `add(Double a, Double b)` για το endpoint `/calc/add`.

3.  **sub(Double a, Double b)**  
    Δίνει το αποτέλεσμα της αφαίρεσης `a - b` στη μεταβλητή `result` και επιστρέφει το αποτέλεσμα.  
    Καλείται στον controller στη μέθοδο `sub(Double a, Double b)`.

4.  **clear()**  
    Δίνει τιμή `null` στη μεταβλητή `result`.  
    Καλείται στον controller στη μέθοδο `clear()` για το endpoint  
    `/calc/memory/clear`.

## Controller Layer

Το αρχείο Controller καλεί τις μεθόδους του `AppServices` μέσω του  
instance:   `private final AppServices appServices;`

Είναι `private` γιατί δεν υπάρχει λόγος να το βλέπει άλλη κλάση και `final`  
επειδή δεν πρέπει να αλλάξει.

## Μέθοδοι

1.  **add(Double a, Double b)**  
    Επιστρέφει `Double` και καλεί τη μέθοδο `addition()`.  
    `@GetMapping("/add")`

    <img width="1140" height="873" alt="add" src="https://github.com/user-attachments/assets/e0352a1a-760a-41bb-b5a6-34839cd34b09" />


2.  **sub(Double a, Double b)**  
    Επιστρέφει `Double` και καλεί τη μέθοδο `sub()`.  
    `@GetMapping("/sub")`

    <img width="1133" height="872" alt="sub" src="https://github.com/user-attachments/assets/2dd8d546-4fad-45c9-b486-ed02f557bfff" />


3.  **memory()**  
    Επιστρέφει το αποτέλεσμα του τελευταίου υπολογισμού καλεί τη μέθοδο `lastResult()`.   
    `@GetMapping("/memory")`

    <img width="1130" height="871" alt="mem" src="https://github.com/user-attachments/assets/40f9459b-dccf-4126-9bc4-b07dfeacb7a3" />


4.  **clear()**  
    Επιστρέφει `void` και καλεί τη μέθοδο `clear()`.  
    `@PostMapping("/memory/clear")`

## Σημείωση

-   LLM χρησιμοποιήθηκε μόνο για διορθώσεις ορθογραφίας και Markdown formatting.
