package algorithm.leetcode.布隆过滤器和LRU;

import java.math.BigDecimal;

/**
 * 元素到底存在不存在
 * 一个很长的二进制向量，一系列随机映射函数
 * 检索一个元素是否在一个集合中
 * 
 * 优点：空间效率和查询时间都远超过一般算法
 * 缺点：有一定的误识别率，删除困难
 * 
 * False positive  假 的 真判定
 * 
 * 在   可能存在
 * 不在 真的不在
 * 
 * 注意，Java的高效实现中用了BitSet和RandomInRange
 * @author david
 *
 */
public class BloomFilter {
	
	private long size;
	private int hash_number;
	private byte[] bits;
	
	public BloomFilter(long size,int hash_number) {
		this.size=size;
		this.bits = new byte[(int) (size/8)];
		this.hash_number = hash_number;
		for(int i=0;i<bits.length;i++) {
			bits[i] = (byte) (bits[i] & (~0<<8));
		}
		
	}
	public void add(String str) {
		
		for(int i=0;i<hash_number;i++) {
			BigDecimal hashcode = Murmurs.hashUnsigned(str, i);
			long position = hashcode.divideAndRemainder(BigDecimal.valueOf(size))[1].longValue();
		
			int num_bit = (int) (position / 8);
			int bit_position = (int) (position % 8);
			byte b = bits[ num_bit];
			//仅将第n位置为1：x|(1<<n)
			bits[ num_bit] = (byte) (b|(1<<bit_position));
		}
		
		
	}
	public boolean lookup(String s) {
		
		for(int i=0;i<hash_number;i++) {
			BigDecimal hashcode = Murmurs.hashUnsigned(s, i);
			long position = hashcode.divideAndRemainder(BigDecimal.valueOf(size))[1].longValue();

			int num_bit = (int) (position / 8);
			int bit_position = (int) (position % 8);
			byte b = bits[ num_bit];
			//获取x的第n位值(0或1)：(x>>n)&1
			int indicator = (b>>bit_position)&1;
			if(indicator==0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		BloomFilter bloomFilter = new BloomFilter(1024,3);
		bloomFilter.add("王大伟");
		bloomFilter.add("王舜华");
		System.out.println(bloomFilter.lookup("王大伟"));
		System.out.println(bloomFilter.lookup("王舜华"));
		System.out.println(bloomFilter.lookup("王华"));
		System.out.println();
	}
	

}
