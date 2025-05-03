package ressources;


public abstract class Constantes {
	//Dimensions de la fenetre
	public static final int LARGEUR_FENETRE = 674;
	public static final int HAUTEUR_FENETRE = 689;
	public static final int COTE_CAREE = 44;
	
	//map1
	public static int[][] tab ={
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 4, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 4, 1},
			{1, 2, 1, 2, 1, 1, 2, 2, 2, 1, 1, 2, 1, 2, 1},
			{1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1},
			{1, 2, 2, 1, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2, 1},
			{1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1},
			{1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1},
			{3, 2, 2, 1, 2, 2, 2, 0, 2, 2, 2, 1, 2, 2, 3},
			{1, 1, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 1, 1},
			{1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1},
			{1, 2, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 2, 1},
			{1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1},
			{1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 1},
			{1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 4, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	};
	//map2
	public static int[][] tab2 ={
			{1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
			{1, 4, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 4, 1},
			{1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1},
			{1, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 1},
			{1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1},
			{1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1},
			{1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1},
			{3, 2, 2, 1, 2, 2, 2, 0, 2, 2, 2, 1, 2, 2, 3},
			{1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 1},
			{1, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1},
			{1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1},
			{1, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 1},
			{1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1},
			{1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 4, 1},
			{1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
	};
	
	//Dimensions de pacman
	public static final int COTE_PAC = 44;
	
	//Position de pacman tab
	public  static int X_POS_PAC = 7;
	public  static int Y_POS_PAC = 7;
	
	//Vie pac
	public static int VIE_PAC = 3;
	
	//Unite de deplacement tab
	public final static int DEPLACEMENT_X_TAB = 1;
	public final static int DEPLACEMENT_Y_TAB = 1;
	
	//Unite de deplacement pix
	public final static int DEPLACEMENT_X_PIX = 44;
	public final static int DEPLACEMENT_Y_PIX = 44;
	
	//Unite de deplacement porte
	public final static int DEPLACEMENT_PORTE = 13;
	
	//sens deplacement 
	public static int sens = 0;
	
	//Dimensions de fontome
	public static final int COTE_FANTOME = 44;
	
	//Position de fantome1 tab
	public final static int X_POS_FANT1 = 1;
	public final static int Y_POS_FANT1 = 1;
	
	//Position de fantome2 tab
	public final static int X_POS_FANT2 = 13;
	public final static int Y_POS_FANT2 = 13;
	
	//Position de fantome3 tab
	public final static int X_POS_FANT3 = 1;
	public final static int Y_POS_FANT3 = 13;
	
	//Position de fantome4 tab
	public final static int X_POS_FANT4 = 13;
	public final static int Y_POS_FANT4 = 1;
	
	//Position retour fantomes tab
		public final static int X_POS_FANTR= 7;
		public final static int Y_POS_FANTR = 7;
		
	
	//Dimensions de pomme blue
	public static final int COTE_POMME = COTE_CAREE / 10;
	
	//Dimensions de pomme speciale
	public static final int COTE_POMME_SPECIALE = COTE_POMME + 5;
	
	//Centrer pomme
	public static final int CENTRER_POMME = 25;
	
	//Centrer pomme speciale
	public static final int CENTRER_POMME_SPECIALE = 20;
	
	//Score pomme bleu
	public static final int POINT_POMME_BLEU = 100;
	
	//Score pomme violet
	public static final int POINT_POMME_VIOLET = 300;
		
	//Score pomme orange
	public static final int POINT_POMME_ORANGE = 500;
		
	//Score pomme vert
	public static final int POINT_POMME_VERT = 1000;
	
	//Position de POMME1 tab
	public final static int X_POS_POMME1 = 1;
	public final static int Y_POS_POMME1 = 1;
			
	//Position de POMME2 tab
	public final static int X_POS_POMME2 = 13;
	public final static int Y_POS_POMME2 = 13;
			
	//Position de POMME3 tab
	public final static int X_POS_POMME3 = 1;
	public final static int Y_POS_POMME3 = 13;
	
	//Score fin de jeu
	public static int SCORE_POUR_VIE_PLUS = 5000;
	
	//Affichage Score position 
	public static final int SCORE_X = 20;
	public static final int SCORE_Y = 30;
	
	//Affichage Vie position 
	public static final int VIE_X = 530;
	public static final int VIE_Y = 30;
	
	
	
}