import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import parser.JsonParserTest;
import shop.CartTest;
import shop.RealItemTest;
import shop.VirtualItem;
import shop.VirtualItemTest;


@RunWith(value = JUnitPlatform.class)
@SelectClasses(VirtualItemTest.class)
@IncludeTags(value =  {"fast"})
public class junit5Runner {
}
