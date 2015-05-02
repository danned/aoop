import bouncingBalls.Model;
import bouncingBalls.View;
import bouncingBalls.Controller;


public class Application
{
	public static void main(String[] args)
	{
    //Construct all the components
	  Model      model      = new Model();
	  View       view       = new View();
	  Controller controller = new Controller();
	  
	  //Notify each component of the other components it needs to refer to
	  model.addView(view);
	  controller.addModel(model);
	  controller.addView(view);
	  view.addModel(model);
	  view.addController(controller);
	  
	  //Build the application, then show it on the screen
	  view.build();
		view.show();
	}
}