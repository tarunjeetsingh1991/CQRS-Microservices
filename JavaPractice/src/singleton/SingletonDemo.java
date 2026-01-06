package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.*;

class Singleton
{
	private static Singleton obj;
	
	private Singleton()
	{
		if(obj != null)
		{
			throw new RuntimeException("Use getInstance() method to create the objects");
		}
	}
	
	public static final Singleton getInstance()
	{
		if(obj == null)
		{
			synchronized(Singleton.class)
			{
				if(obj == null)
				{
					obj = new Singleton();
				}
			}
		}
		return obj;
	}
}
public class SingletonDemo 
{
	public static void main(String[] args) throws InterruptedException, ExecutionException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		Callable<Singleton> task = () -> Singleton.getInstance();
		
		Future<Singleton> f1 = exec.submit(task);
		Future<Singleton> f2 = exec.submit(task);
		
		Singleton ob1 =  f1.get();
		Singleton ob2 =  f2.get();
		
		System.out.println(ob1.hashCode());
		System.out.println(ob2.hashCode());
		
		exec.shutdown();
		
		try
		{
			Singleton obj1 = Singleton.getInstance();
			
			Constructor<Singleton> cons = Singleton.class.getDeclaredConstructor();
			cons.setAccessible(true);
			
			Singleton obj2 = cons.newInstance();
			
			System.out.println(obj1.hashCode());
			System.out.println(obj2.hashCode());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getCause().getMessage());
		}
		
		
	}

}
