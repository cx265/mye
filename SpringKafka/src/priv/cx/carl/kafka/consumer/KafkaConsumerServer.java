package priv.cx.carl.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月29日 下午9:00:19
 */
public class KafkaConsumerServer implements MessageListener<String, String> {

	protected final Logger LOG = LoggerFactory.getLogger("kafkaConsumer");

	/**
	 * 监听器自动执行该方法 消费消息 自动提交offset 执行业务代码 （high level api
	 * 不提供offset管理，不能指定offset进行消费）
	 */
	@Override
	public void onMessage(ConsumerRecord<String, String> record) {
		LOG.info("=============kafkaConsumer开始消费=============");
		String topic = record.topic();
		String key = record.key();
		String value = record.value();
		long offset = record.offset();
		int partition = record.partition();
		LOG.info("-------------topic:" + topic);
		LOG.info("-------------value:" + value);
		LOG.info("-------------key:" + key);
		LOG.info("-------------offset:" + offset);
		LOG.info("-------------partition:" + partition);
		LOG.info("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
	}
}
