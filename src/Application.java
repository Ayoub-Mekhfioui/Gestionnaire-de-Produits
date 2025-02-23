import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        int choix;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    List<Produit> produits = metier.getAll();
                    for (Produit produit : produits) {
                        System.out.println(produit);
                    }
                    break;
                case 2:
                    System.out.print("Entrez l'id du produit: ");
                    long id = scanner.nextLong();
                    Produit produit = metier.findById(id);
                    if (produit != null) {
                        System.out.println(produit);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;
                case 3:
                    System.out.print("Entrez l'id du produit: ");
                    long newId = scanner.nextLong();
                    scanner.nextLine(); // Pour consommer la nouvelle ligne
                    System.out.print("Entrez le nom du produit: ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque du produit: ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix du produit: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Pour consommer la nouvelle ligne
                    System.out.print("Entrez la description du produit: ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock: ");
                    int nombreEnStock = scanner.nextInt();

                    Produit newProduit = new Produit(newId, nom, marque, prix, description, nombreEnStock);
                    metier.add(newProduit);
                    System.out.println("Produit ajouté avec succès.");
                    break;
                case 4:
                    System.out.print("Entrez l'id du produit à supprimer: ");
                    long idToDelete = scanner.nextLong();
                    metier.delete(idToDelete);
                    System.out.println("Produit supprimé avec succès.");
                    break;
                case 5:
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}