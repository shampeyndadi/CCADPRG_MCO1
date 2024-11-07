import java.util.Scanner
import java.util.InputMismatchException

fun pauseProgram(){
    println("Press Enter to continue...")
    Scanner(System.`in`).nextLine()
}

fun clearConsole() {
    try {
        val os = System.getProperty("os.name")
        if (os.contains("Windows")) {
            ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor()
        } else {
            ProcessBuilder("clear").inheritIO().start().waitFor()
        }
    } catch (e: Exception) {
        println("Unable to clear console.")
    }
}

fun header(){
    println(" _                      __  __           _              ____            ")
    println("| |    ___   __ _ _ __ |  \\/  | __ _ ___| |_ ___ _ __  |  _ \\ _ __ ___  ")
    println("| |   / _ \\ / _` | '_ \\| |\\/| |/ _` / __| __/ _ \\ '__| | |_) | '__/ _ \\ ")
    println("| |__| (_) | (_| | | | | |  | | (_| \\__ \\ ||  __/ |    |  __/| | | (_) |")
    println("|_____\\___/ \\__,_|_| |_|_|  |_|\\__,_|___/\\__\\___|_|    |_|   |_|  \\___/ ")
    println("Helping You Find the Best Financial Path\n")

}


fun calculate() {
    clearConsole()
    header()

    val sc = Scanner(System.`in`)

    var loanAmount = 0.0
    var annualInterestRate = 0.0
    var loanTermYears = 0

    try {
        print("Enter Loan Amount: ")
        loanAmount = sc.nextDouble()

        print("Enter Annual Interest Rate (e.g., 10%): ")
        var rateInput = sc.next()
        
        if (rateInput.endsWith("%")) {
            rateInput = rateInput.removeSuffix("%")
        }
        annualInterestRate = rateInput.toDouble()

        print("Enter Loan Term (years): ")
        loanTermYears = sc.nextInt()

        val monthlyInterestRate = annualInterestRate / 100 / 12
        val loanTermMonths = loanTermYears * 12
        val totalInterest = loanAmount * monthlyInterestRate * loanTermMonths
        val monthlyRepayment = (loanAmount + totalInterest) / loanTermMonths

        clearConsole()

        println("Processing your loan details. Please wait...\n")
        Thread.sleep(1000)
        pauseProgram()

        clearConsole()
        header()

        println("Loan Details:\n")
        println("Loan Amount: PHP %.2f".format(loanAmount))
        println("Annual Interest Rate: %.2f%%".format(annualInterestRate)) 
        println("Loan Term: $loanTermMonths months")
        println("Monthly Repayment: PHP %.2f".format(monthlyRepayment))
        println("Total Interest: PHP %.2f".format(totalInterest))
        println()

        pauseProgram()
        clearConsole()

    } catch (e: InputMismatchException) {
        println("\nOops, invalid input. Please enter a valid number.\n")
        sc.nextLine() 
        pauseProgram()
        clearConsole()
    } catch (e: NumberFormatException) {
        println("\nOops, invalid input format. Please make sure the interest rate is a number.\n")
        pauseProgram()
        clearConsole()
    } catch (e: ArithmeticException) {
        println("Oops, something went wrong with the calculations. Please double-check your inputs.")
        pauseProgram()
        clearConsole()
    }
}


fun main() {
    var breaker = true

    val mainScanner = Scanner(System.`in`)
   
    do {
        header()
        println("What would you like to do? ")
        println("[1] Use your calculator")
        println("[2] Exit program")

        try {
            print("\nEnter input: ")
            val input = mainScanner.nextInt()

            if (input == 1){
                calculate()
            }else if (input == 2){
                clearConsole()
                println(" _____ _                 _     __   __          ")
                println("|_   _| |__   __ _ _ __ | | __ \\ \\ / /__  _   _ ")
                println("  | | | '_ \\ / _` | '_ \\| |/ /  \\ V / _ \\| | | |")
                println("  | | | | | | (_| | | | |   <    | | (_) | |_| |")
                println("  |_| |_| |_|\\__,_|_| |_|_|\\_\\   |_|\\___/ \\__,_|")
                
                println("\nThank you for using LoanMasterPro\n")
                pauseProgram()
                breaker = false
            }else{
                println("\nOops, invalid inputs. Please check your input\n")
                pauseProgram()
            }
        } catch (e: InputMismatchException) {
            println("\nOops, invalid input. Please enter a valid number.\n")
            mainScanner.nextLine()  
            pauseProgram()
            clearConsole()
        }
    } while (breaker)
}
