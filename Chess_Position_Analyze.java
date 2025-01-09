import java.util.Scanner;

public class ChessPositionAnalyzer {

    // Function to validate a basic FEN string format
    public static boolean isValidFEN(String fen) {
        String[] parts = fen.split(" ");
        
        // FEN consists of 6 parts: Board, Active color, Castling availability, En passant target square, Halfmove clock, and Fullmove number
        if (parts.length != 6) {
            return false;
        }

        // Validate board section (should have 8 rows, each with 8 pieces or numbers)
        String[] board = parts[0].split("/");
        if (board.length != 8) {
            return false;
        }
        
        for (String row : board) {
            int count = 0;
            for (char c : row.toCharArray()) {
                if (Character.isDigit(c)) {
                    count += Character.getNumericValue(c);  // A digit represents empty squares
                } else if ("prnbqkPRNBQK".indexOf(c) != -1) {  // Piece identifiers
                    count++;
                }
            }
            if (count != 8) {
                return false;
            }
        }

        return true;
    }

    // Function to analyze the chess position (can be expanded for further checks)
    public static void analyzePosition(String fen) {
        System.out.println("\nChess Position Analysis");
        System.out.println("FEN String: " + fen);
        if (fen.split(" ")[1].equalsIgnoreCase("w")) {
            System.out.println("It's White's turn to move.");
        } else {
            System.out.println("It's Black's turn to move.");
        }

        // Further functionality can be added here (check, checkmate, etc.)
        
        System.out.println("\nAnalysis complete! You can extend functionality to include check, checkmate, and more.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Chess Position Analyzer!");
        
        // Input FEN string for chess position
        System.out.print("Enter the FEN string of the chess position: ");
        String fen = scanner.nextLine().trim();

        // Validate FEN string format
        if (!isValidFEN(fen)) {
            System.out.println("Invalid FEN string. Please ensure it's correctly formatted.");
            return;
        }

        // Analyze and display results
        analyzePosition(fen);

        scanner.close();
    }
}

  
/*
Sample Input:
Enter the FEN string of the chess position: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1

Output:
Welcome to the Chess Position Analyzer!
Enter the FEN string of the chess position: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1

Chess Position Analysis
FEN String: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1
It's White's turn to move.

Analysis complete! You can extend functionality to include check, checkmate, and more.
*/
