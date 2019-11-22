package com.han.web.pxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.han.web.usr.User;
import com.han.web.usr.UserMapper;


@Component("dummy")
public class DummyProxy extends Proxy{

	@Autowired UserMapper userMapper;

	
	private char[] charaters = {'a','b','c','d','e','f','g','h','i',
			   'j','k','l','m','n','o','p','q','r','s','t','u','v','w',
			   'x','y','z','0','1','2','3','4','5','6','7','8','9'};
	
	   private int mailLength = 6; 
	   
	   public String makeUname(){
	       List<String> fName = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
	                 "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
	                 "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
	                 "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
	                 "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
	             List<String> lName = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
	                 "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
	                 "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
	                 "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
	                 "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
	                 "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
	                 "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
	                 "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
	                 "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
	                 "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
	             Collections.shuffle(fName);
	             Collections.shuffle(lName);
	             String fullName = fName.get(0) + lName.get(0) + lName.get(1);
	             return fullName;
	           }
	   
	  
	   public String makeAge () {
			return String.format("%02d", random(1, 100)); 
		}
		
		public String makeGender () {
			return (random(10, 10))%2 == 0 ? "남" : "여"; 
		}
		
		public String makeTel () {
			return String.format("%03d",random(1, 100))+"-"+String.format("%04d",random(1, 1000));
		}
		
		public String makeUpoint () {
			return String.format("%04d",random(1, 1000));
		}
		
		public String makeScore () {
			return String.format("%03d",random(1, 100));
		}
		
		public String makeMvp () {
			return String.format("%02d",random(1, 100));
		}
		
		public String makeWin () {
			return String.format("%02d",random(1, 100));
		}
		public String makeKm () {
			return String.format("%03d",random(3, 100));
		}
	   public int setCalendars(){
	        int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        int iMinMonth = 1;
	        int iMaxMonth = 12;
	        int iRandomMonth = (int)(Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
	        int iRandomDay = (int)(Math.random() * (maxDays[iRandomMonth-1] -2) + 1);
	        int iUserBirthMonth = iRandomMonth;
	        int iUserBirthDay = iRandomDay;
	        return 0;
	      }
	   
	private String makeLolName() {
		List<String> lName = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
		        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
		        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
		        "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
		        "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
		        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
		        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
		        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
		        "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
		        "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");

		    Collections.shuffle(lName);
		    String lolName = "소환사" + lName.get(0) + lName.get(1) + "님";
		return lolName;
	}

	private String makeUid() {
		StringBuffer buffer = new StringBuffer();
		Random ran = new Random();

		String name[] = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");

		for (int i = 0; i < 7; i++) {
			buffer.append(name[ran.nextInt(name.length)]);
		}
		return buffer.toString();
	}

	private String makeEmail() {
		StringBuffer buffer = new StringBuffer();
		Random ran = new Random();

		for (int i = 0; i < 5; i++) {
			buffer.append(charaters[ran.nextInt(charaters.length)]);
		}
		return buffer.toString()+"@aSibal.net";
	}

		public String makeAuthor () {
			return (random(10, 10))%2 == 0 ? "1" : "0"; 
		}
		
		 private String makeLoc() {
			   	List<String> loc = Arrays.asList("서울","경기","충청");
			   	Collections.shuffle(loc);
				return loc.get(0);
			}
		 

	public User makeUser() {
		return new User(makeUid(), makeUname(), "1", makeTel(),makeUpoint(), makeAge(), makeLoc(),makeGender(),  makeEmail(),
				null, null, null);
	}

	@Transactional
	public void insertUsers() {
		for (int i = 0; i < 500; i++) {
			userMapper.insertUser(makeUser());
		}
	}
}
