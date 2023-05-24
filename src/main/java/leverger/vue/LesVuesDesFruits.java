package leverger.vue;

public class LesVuesDesFruits {
	public VuesDesFruits cerises;
	public VuesDesFruits poires;
	public VuesDesFruits prunes;
	public VuesDesFruits pommes;
	
	public LesVuesDesFruits(VuesDesFruits vuesdescerises, VuesDesFruits vuesdespoires, VuesDesFruits vuesdesprunes, VuesDesFruits vuesdespommes ) {
		this.cerises = vuesdescerises;
		this.poires = vuesdespoires;
		this.prunes = vuesdesprunes;
		this.pommes = vuesdespommes;
	}
}
