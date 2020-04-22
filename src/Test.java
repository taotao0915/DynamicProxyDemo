import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {//动态代理测试
        JavaDeveloper javaDeveloper = new JavaDeveloper();
        //动态代理类-可以在运行时可动态修改类中方法的相关逻辑
        Developer proxy = (Developer) Proxy.newProxyInstance(javaDeveloper.getClass().getClassLoader()
                , javaDeveloper.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("code")){
                            System.out.println("UML建模并确定开发框架");
                            return method.invoke(javaDeveloper,args);
                        }
                        if(method.getName().equals("debug")){
                            System.out.println("检查代码");
                            return method.invoke(javaDeveloper,args);
                        }
                        return null;
                    }
                });
        proxy.code();//会执行到InvocationHandler的invoke方法
        proxy.debug();//会执行到InvocationHandler的invoke方法
    }
}
