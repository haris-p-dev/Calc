# Calculator API

Το project ζητάει μέσα από τα παρακάτω endpoints:

1.  **Addition**: `GET /calc/add?a=5&b=3`\
2.  **Subtraction**: `GET /calc/sub?a=10&b=4`\
3.  **Get Memory**: `GET /calc/memory`\
4.  **Clear Memory**: `POST /calc/memory/clear`

να γίνουν οι αντίστοιχες πράξεις.

-   Endpoint `/calc/add?a=5&b=3` μετά από GET request επιστρέφει
    αποτέλεσμα πρόσθεσης.\
-   Endpoint `/calc/sub?a=3&b=3` μετά από GET request επιστρέφει
    αποτέλεσμα διαίρεσης.\
-   Endpoint `/calc/memory` έχοντας υλοποίηση αποθήκευσης στο service,
    επιστρέφει το τελευταίο αποτέλεσμα οποιασδήποτε από τις παραπάνω
    πράξεις.\
-   Endpoint `/calc/memory/clear` καθαρίζει αυτή τη μνήμη (POST).

------------------------------------------------------------------------

## Δομή Project

Το project χωρίζεται σε 3 μέρη:

-   Το `DemoApplication`, που είναι η έναρξη του project.\
-   Στον φάκελο **Controllers**, που περιέχει το αρχείο
    `CalculatorController`.\
-   Στον φάκελο **Services**, που περιέχει το αρχείο `AppServices`.

------------------------------------------------------------------------

## Service Layer

Το `AppServices` περιέχει όλη τη λογική του API.

Δημιουργείται μια εντελώς κενή λίστα. Αυτό σημαίνει ότι δεν περιέχει
καμία τιμή (ούτε null). Χρησιμοποιήθηκε λίστα γιατι επιτρεπει διαγραφή, γρήγορο get.  

### Μέθοδοι

1.  **lastResult()**\
    Επιστεφει την τιμη του var 
    Καλείται στον controller στη μέθοδο `memory()` για το endpoint
    `/calc/memory`.

2.  **addition(long a, long b)**\
    Πρώτα αποθηκεύουμε στη θέση 0 της λίστας το αποτέλεσμα των 2
    arguments και μετά επιστρέφουμε `a + b`.\
    Καλείται στον controller στη μέθοδο `add(long a, long b)` για το
    endpoint `/calc/add`.

3.  **sub(long a, long b)**\
    Αν το `b = 0`, πετάει exception `"Cannot divide by zero."`.\
    Αν δεν συμβαίνει τίποτα από τα παραπάνω, αποθηκεύει το αποτέλεσμα
    στη θέση 0 της λίστας και επιστρέφει το αποτέλεσμα `a / b`.\
    Καλείται στον controller στη μέθοδο `sub(long a, long b)`.

4.  **clear()**\
    Γυρίζει `String`.\
    Όταν η λίστα είναι ήδη κενή, επιστρέφει μήνυμα
    `"List is already clear"`.\
    Αν υπάρχει element στη λίστα, στη θέση 0 βάζει `null` και επιστρέφει
    `"List cleared"`.\
    Καλείται στον controller στη μέθοδο `clear()` για το endpoint
    `/memory/clear`.

------------------------------------------------------------------------

## Controller Layer

Το αρχείο Controller καλεί τις μεθόδους του `AppServices` μέσω του
instance:

`private final AppServices appServices;`

Είναι private γιατί δεν υπάρχει λόγος να το βλέπει άλλη κλάση και final
επειδή δεν πρέπει να αλλάξει.

------------------------------------------------------------------------

## Μέθοδοι

1.  **add(long a, long b)**\
    Επιστρέφει `long` και καλεί τη μέθοδο `addition`.\
    `@GetMapping("/add")`
    <img width="1916" height="854" alt="calc-add" src="https://github.com/user-attachments/assets/a4458313-22da-4ab9-aa2a-0bd9cf455f68" />
    <img width="1918" height="828" alt="calc-add2" src="https://github.com/user-attachments/assets/172427cd-ad31-4785-9e9c-6e6f0b2920e2" />


3.  **sub(long a, long b)**\
    Επιστρέφει `long` και καλεί τη μέθοδο `sub`.\
    `@GetMapping("/sub")`
<img width="1134" height="769" alt="calc-sub" src="https://github.com/user-attachments/assets/b929ec6f-8dd0-4363-a414-7b7c68a2e31a" />


5.  **memory()**\
    Επιστρέφει `long` και καλεί τη μέθοδο `lastResult()`.\
    `@GetMapping("/memory")`
<img width="1912" height="823" alt="calc-memory" src="https://github.com/user-attachments/assets/108710ee-1064-42bd-bf7c-82569e49301a" />


7.  **clear()**\
    Επιστρέφει `void` και καλεί τη μέθοδο `clear`.\
    `@PostMapping("/memory/clear")`
<img width="1150" height="192" alt="calc-memory-clear" src="https://github.com/user-attachments/assets/0124fd14-41fd-4e73-827e-4a8bb5d29db6" />
<img width="1406" height="222" alt="calc-memory-clear terminal" src="https://github.com/user-attachments/assets/9bed037a-7477-4960-b94a-f4967f941382" />

------------------------------------------------------------------------

## Βελτιώσεις Κώδικα

-   Οι παράμετροι στις μεθόδους `add` και `sub` να δέχονται μόνο
    αριθμούς.

------------------------------------------------------------------------

## Σημείωση

-   LLM χρησιμοποιήθηκε μόνο για διορθώσεις ορθογραφίας και Markdown
    formatting.
