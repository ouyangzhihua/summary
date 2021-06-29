package string_operate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L49GroupAnagrams {
	/*
	 * 49. 字母异位词分组
	 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
	 */
	public List<List<String>> groupAnagrams(String[] strs)
	{
		Map<String, List<String>> dic = new HashMap<>();
		for(String str : strs)
		{
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);
			List<String> list = dic.getOrDefault(key, new ArrayList<String>());
			list.add(str);
			dic.put(key, list);
		}
		return new ArrayList<List<String>>(dic.values());
	}
}
