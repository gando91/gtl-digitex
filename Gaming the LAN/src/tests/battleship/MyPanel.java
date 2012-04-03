package tests.battleship;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * this class describe the panel of palyer 
 * with the sub panel of situation and
 * the sub panel of status of player's ship
 *
 */




public class MyPanel extends JPanel {
	
	
	private static int rows=11;
	private static int cols=11;
	
	
	 public MyPanel() {
	        initComponents();
	        Color c = new Color (0, 0, 0, 0);
			setBackground(c); 
			setOpaque(true);
			
	 }
	 
	 private void initComponents() {
	    	

	        jPanel1 = new javax.swing.JPanel();   //sx
	        jPanel2 = new javax.swing.JPanel();   //dx

	        //jPanel1.setBackground(new java.awt.Color(51, 51, 255));
	        Color c = new Color (0, 0, 0, 0);
			jPanel1.setBackground(c); 
			jPanel1.setOpaque(true);
	        jPanel1.setPreferredSize(new java.awt.Dimension(230, 230));

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 230, Short.MAX_VALUE)
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 230, Short.MAX_VALUE)
	        );

	        jPanel2.setBackground(Color.BLACK);
	        jPanel2.setPreferredSize(new java.awt.Dimension(230, 230));

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 150, Short.MAX_VALUE)
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 230, Short.MAX_VALUE)
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())
	        );
	        
	     }
	 
	 @Override
	public void paint(Graphics g) { 
		 
		super.paint(g);
		
		for (Integer i = 0; i < rows; i++) {
			for (Integer j = 0; j < cols; j++) {
				g.setColor(Color.BLUE);
				g.fillRect(((225/11)*j)+17, ((223/11)*i)+17, (225/11), (223/11));
				g.setColor(Color.WHITE);
				g.drawRect(((225/11)*j)+17, ((223/11)*i)+17, (225/11), (223/11));
				
				if(j==0 && i!=0)
					g.drawString(i.toString(),(223/11), (i*(223/11))+(223/11)+10);
					
				
				//drawLetters(g, i, j);
				
			}
		}
		
		
		
		
		
	}

	    // Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    // End of variables declaration//GEN-END:variables
}



