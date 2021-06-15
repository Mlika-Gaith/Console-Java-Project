package gestionGarderie.Gestion;

public class Affichage {
	
	private int maxWidth = 0;
	private int nombreColonnes = 0;
	private int columnWidth = 0;
	
	
	public Affichage () {
		
	}
	public Affichage(int nombreColonnes, int columnWidth) {
		this.nombreColonnes = nombreColonnes;
		this.columnWidth = columnWidth;
		maxWidth = columnWidth*nombreColonnes;
	}
	
	public void setColumnWidth(int columnWidth) {
		this.columnWidth = columnWidth;
	}
	public void setColumnNumber(int nombreColonnes) {
		this.nombreColonnes = nombreColonnes;
		maxWidth = columnWidth*nombreColonnes;
	}
	
	
	public void setTitle (String title) {
		
		
		for (int i=0; i<maxWidth; i++) {
			System.out.print("-");
			
		}
		
		System.out.print("\n");
		title = title.toUpperCase();
		
		if (title.length()%2 != 0) {
			int space1 = (maxWidth - title.length()-2)/2;
			int space2 = ((maxWidth - title.length()-2)/2)+1;
			System.out.printf("|%"+space1+"s%s%"+space2+"s|","",title,"");
		}
		else {
			int space = (maxWidth - title.length()-2)/2;
			System.out.printf("|%"+space+"s%s%"+space+"s|","",title,"");
			
		}
		
		System.out.print("\n");
		for (int i=0; i<maxWidth; i++) {
			System.out.print("-");
		}
		
		System.out.print("\n");
	}
	
	public void setColumnTitles (String [] titles) {
		

		
		for ( int i=0; i<titles.length; i++) {
			
			if ( i != titles.length-1) {
				String title = titles[i];
				int space = (columnWidth- (title.length()+2));
				System.out.printf("| %s%"+space+"s",title,"");
			}
			else {
				String title = titles[i];
				int space = (columnWidth- (title.length()+3));
				System.out.printf("| %s%"+space+"s",title,"");
			}
			
		}
		System.out.print("|\n");
		for (int i=0; i<maxWidth; i++) {
			System.out.print("-");
			
		}
		
		System.out.print("\n");
	}
	

	
	public void addColumn(String str) {
		
		
		int space = (columnWidth-str.length())-2;
		System.out.printf("| %s%"+space+"s",str,"");
	}
	
	public void addLastColumn (String str) {
		int space = (columnWidth-str.length())-3;
		System.out.printf("| %s%"+space+"s",str,"");
	}
	
	
	
	public void endLine() {
		System.out.print("|\n");
		for (int i=0; i<maxWidth; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
	
}
