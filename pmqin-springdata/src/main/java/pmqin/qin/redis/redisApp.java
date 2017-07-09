package pmqin.qin.redis;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class redisApp {

	public static void main(String[] args) {
		 Jedis jedis = new Jedis("192.168.118.128");
		 jedis.set("foo", "bar");
		 String value = jedis.get("foo");
       
//		 Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//		//抛出ERR This instance has cluster support disabled.此时由于redis未开启Redis Cluster。在配置中设置cluster-enabled即可。
//		 jedisClusterNodes.add(new HostAndPort("192.168.118.128", 6379));
//		 JedisCluster jc = new JedisCluster(jedisClusterNodes);
//		 jc.set("foo", "bar");
//		 String value1 = jc.get("foo");
		 System.out.println(value);
		 
		 //http://blog.csdn.net/canot/article/details/52702029  更多实现方法
		//http://blog.csdn.net/truong/article/details/46711045 更多其他的
		//淘宝的http://www.open-open.com/lib/view/open1389880631976.html
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		
		UserDao userDAO = (UserDao) ac.getBean("userDao");
		UserInfo user = new UserInfo();
		user.setId(1);
		user.setUsername("qinmmnm");
		//userDAO.saveUser(user);

		UserInfo liuxg = userDAO.getUser(1);
		System.out.println(liuxg.getUsername());

	}

}
