import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

class Produit {
    private String nom;
    private String description;
    private int prix;

    public Produit(String nom, String description, int prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void afficher() {
        System.out.println("Nom: " + nom);
        System.out.println("Description: " + description);
        System.out.println("Prix: " + prix);
    }
}

class ProduitElectronique extends Produit {
    private int dureeGarantie;

    public ProduitElectronique(String nom, String description, int prix, int dureeGarantie) {
        super(nom, description, prix);
        this.dureeGarantie = dureeGarantie;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Durée de garantie (en mois): " + dureeGarantie);
    }
}

class ProduitAlimentaire extends Produit {
    private LocalDate dateExpiration;

    public ProduitAlimentaire(String nom, String description, int prix, LocalDate dateExpiration) {
        super(nom, description, prix);
        this.dateExpiration = dateExpiration;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Date d'expiration: " + dateExpiration);
    }
}

class ProduitBoisson extends Produit {
    private int quantite;

    public ProduitBoisson(String nom, String description, int prix, int quantite) {
        super(nom, description, prix);
        this.quantite = quantite;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Quantité (en cl): " + quantite);
    }
}

class Boutique {
    private List<Produit> produits;

    public Boutique() {
        this.produits = new ArrayList<>();
    }

    public void addProduit(Produit produit) {
        produits.add(produit);
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void afficherStock() {
        for (Produit produit : produits) {
            produit.afficher();
            System.out.println(); // Ajout d'une ligne vide pour séparer les produits
        }
    }
}

class Panier {
    private List<Produit> produits;

    public Panier() {
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public int prixTotalPanier() {
        int total = 0;
        for (Produit produit : produits) {
            total += produit.getPrix();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        // Création de la boutique
        Boutique boutique = new Boutique();

        // Ajout de produits à la boutique
        boutique.addProduit(new ProduitAlimentaire("Pommes", "Des pommes fraîches", 2, LocalDate.now().plusDays(7)));
        boutique.addProduit(new ProduitElectronique("Téléphone", "Un smartphone de dernière génération", 500, 12));
        boutique.addProduit(new ProduitBoisson("Coca-Cola", "Boisson gazeuse", 1, 500));

        // Affichage des produits de la boutique
        System.out.println("Produits disponibles dans la boutique :");
        boutique.afficherStock();

        // Test du panier
        Panier panier = new Panier();
        panier.ajouterProduit(new ProduitAlimentaire("Lait", "Lait entier", 1, LocalDate.now().plusDays(3)));
        panier.ajouterProduit(new ProduitElectronique("Casque audio", "Casque sans fil", 100, 6));
        panier.ajouterProduit(new ProduitBoisson("Eau minérale", "Eau plate", 0, 1500));

        // Affichage du prix total du panier
        System.out.println("Prix total du panier : " + panier.prixTotalPanier());
    }
}