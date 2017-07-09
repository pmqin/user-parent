package pmqin.qin.redis;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	protected RedisTemplate<Serializable, Serializable> redisTemplate;
	
	
	public void saveUser(final UserInfo user) {
        redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection connection) throws DataAccessException {

                connection.set(redisTemplate.getStringSerializer().serialize(user.getId() + ""),
                        redisTemplate.getStringSerializer().serialize(user.getUsername()));

                return null;
            }

        });
    }
	
	 public UserInfo getUser(final long id) {
	        return redisTemplate.execute(new RedisCallback<UserInfo>() {

	            public UserInfo doInRedis(RedisConnection connection) throws DataAccessException {
	                byte[] key = redisTemplate.getStringSerializer().serialize(id + "");
	                if (connection.exists(key)) {
	                    byte[] value = connection.get(key);
	                    System.out.println("key="+key);
	                    String name = redisTemplate.getStringSerializer().deserialize(value);
	                    UserInfo user = new UserInfo();
	                    user.setUsername("qion");
	                    user.setId(1111);
	                    return user;
	                }
	                return null;
	            }

	        });
	    }
}
