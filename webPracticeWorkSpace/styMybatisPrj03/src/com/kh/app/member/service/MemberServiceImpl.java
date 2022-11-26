package com.kh.app.member.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import static com.kh.app.common.db.JDBCTemplate.*;
import com.kh.app.common.page.PageVo;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.dao.MemberDaoImpl;
import com.kh.app.member.vo.MemberVo;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao dao = new MemberDaoImpl();
	
	@Override
	public int join(MemberVo vo) {
		SqlSession ss = getSqlSession();
		
		int result = dao.join(ss, vo);
		
		if(result == 1) {
			ss.commit();
		}
		
		ss.close();
		
		return result;
	}

	@Override
	public MemberVo login(MemberVo vo) {
		SqlSession ss = getSqlSession();
		
		MemberVo loginMember = dao.login(ss, vo);
		
		ss.close();
		
		return loginMember;
	}

	@Override
	public List<MemberVo> selectMemberList(Map searchMap, PageVo pv) {
		SqlSession ss = getSqlSession();
		
		List<MemberVo> voList = dao.selectMemberList(ss, searchMap, pv);
		
		ss.close();
		
		return voList;
	}

	@Override
	public MemberVo selectMemberOne(int memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(MemberVo vo) {
		SqlSession ss = getSqlSession();
		
		int result = dao.updateMember(ss, vo);
		
		ss.close();
		
		return result;
	}

	@Override
	public int deleteMember(MemberVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCount() {
		SqlSession ss = getSqlSession();
		
		int listCount = dao.selectCount(ss);
		
		ss.close();
		
		return listCount;
	}

}
