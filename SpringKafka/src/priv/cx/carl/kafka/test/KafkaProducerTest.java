package priv.cx.carl.kafka.test;

import java.util.Map;

import priv.cx.carl.kafka.producer.KafkaProducerServer;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月29日 下午9:14:24
 */
public class KafkaProducerTest {

	public static void main(String[] args) {

		KafkaProducerServer kafkaProducer = new KafkaProducerServer();
		String topic = "orderTopic";
		String value = "test";
		String ifPartition = "0";
		Integer partitionNum = 3;
		String role = "test";// 用来生成key
		Map<String, Object> res = kafkaProducer.sndMesForTemplate(topic, value, ifPartition, partitionNum, role);

		System.out.println("测试结果如下：===============");
		String message = (String) res.get("message");
		String code = (String) res.get("code");

		System.out.println("code:" + code);
		System.out.println("message:" + message);
	}
}
