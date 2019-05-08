package Client;

import java.util.ArrayList;

import Clases.JajaUyPapiQuePutasException;

/*
 * @author Lele
 * Clase que hace de todo... Creo...
 * Aiuda...
 */
public class Layout
{
	public final Orientation orientation;
	public final Point size;
	public final Point origin;
	static public Orientation pointy = new Orientation(Math.sqrt(3.0), Math.sqrt(3.0) / 2.0, 0.0, 3.0 / 2.0, Math.sqrt(3.0) / 3.0, -1.0 / 3.0, 0.0, 2.0 / 3.0, 0.5);
	static public Orientation flat = new Orientation(3.0 / 2.0, 0.0, Math.sqrt(3.0) / 2.0, Math.sqrt(3.0), 2.0 / 3.0, 0.0, -1.0 / 3.0, Math.sqrt(3.0) / 3.0, 0.0);
	/*
	 * Constructor de esta clase bastarda...
	 * Que putas es esta clase si quiera...
	 */
	public Layout(Orientation orientation, Point size, Point origin)
	{
		this.orientation = orientation;
		this.size = size;
		this.origin = origin;
	}


	/*
	 * Obtiene la coordenada en pixeles del hexagono.
	 */
	public Point hexToPixel(Hex h)
	{
		Orientation M = orientation;
		double x = (M.f0 * h.getQ() + M.f1 * h.getR()) * size.x;
		double y = (M.f2 * h.getQ() + M.f3 * h.getR()) * size.y;
		return new Point(x + origin.x, y + origin.y);
	}

	/*
	 * Desface de las esquinas.
	 */
	public Point hexCornerOffset(int corner)
	{
		Orientation M = orientation;
		double angle = 2.0 * Math.PI * (M.start_angle - corner) / 6.0;
		return new Point(size.x * Math.cos(angle), size.y * Math.sin(angle));
	}

	/*
	 * Esquinas de un hexagono
	 */
	public ArrayList<Point> polygonCorners(Hex h)
	{
		ArrayList<Point> corners = new ArrayList<Point>();
		Point center = hexToPixel(h);
		for (int i = 0; i < 6; i++)
		{
			Point offset = hexCornerOffset(i);
			corners.add(new Point(center.x + offset.x, center.y + offset.y));
		}
		return corners;
	}
	/*
	 * Obtiene la coordenada de un hexagono en un punto p.
	 */
	public FractionalHex pixelToHex(Point p) throws JajaUyPapiQuePutasException
	{
		Orientation M = orientation;
		Point pt = new Point((p.x - origin.x) / size.x, (p.y - origin.y) / size.y);
		double q = M.b0 * pt.x + M.b1 * pt.y;
		double r = M.b2 * pt.x + M.b3 * pt.y;
		return new FractionalHex(q, r, -q - r, null);
	}


}



