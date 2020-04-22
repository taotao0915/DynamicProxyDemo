/**
 * Java开发人员
 */
public class JavaDeveloper implements Developer{
    @Override
    public void code() {
        System.out.println("写java代码");
    }

    @Override
    public void debug() {
        System.out.println("调试java代码");
    }
}
