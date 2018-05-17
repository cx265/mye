package priv.cx.carl.activemq;

import java.text.DecimalFormat;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年6月9日 上午10:55:08
 */
public class Listener implements MessageListener {

	public void onMessage(Message message) {
		try {
			MapMessage map = (MapMessage) message;
			String stock = map.getString("stock");
			double price = map.getDouble("price");
			double offer = map.getDouble("offer");
			boolean up = map.getBoolean("up");
			DecimalFormat df = new DecimalFormat("#,###,###,##0.00");
			System.out.println(stock + "\t" + df.format(price) + "\t" + df.format(offer) + "\t" + (up ? "up" : "down"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
