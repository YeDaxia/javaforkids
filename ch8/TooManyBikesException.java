/**
 * @author Yakov Fain (www.smartdataprocessing.com)
 * 
 *         This is a code sample from the book Java Programming for Kids,
 *         Parents and Grandparents.
 */
class TooManyBikesException extends Exception{
    // 构造方法
    TooManyBikesException (){
        // 只调用父类的构造方法，并把错误显示信息传递给它
        super("Can't ship this many bikes in one shipment.");
    }
}