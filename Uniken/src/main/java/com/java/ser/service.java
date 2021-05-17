package com.java.ser;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.dao;

import com.java.entity.Corporate1;

import com.java.entity.User;
@Service
public class service {
	/// Service Layer
	
	@Autowired
	dao mvcd;
	public boolean checklogin(User user) {
		System.out.println("111566");
		// TODO Auto-generated method stub
		boolean result=mvcd.checklogin(user);
		return result;
	}
	
	
	public List<Corporate1> getcor() {
		 List<Corporate1> listcor=mvcd.getcor();
			return listcor;
	}


	public boolean addcor(Corporate1 cor) {
		// TODO Auto-generated method stub
		return mvcd.addcor(cor);
	}


	public boolean deletecor(int stid) {
		// TODO Auto-generated method stub
		return mvcd.deletecor(stid);
	}

	public List<Corporate1> getproj(int idprj) {
		List<Corporate1> listproj=mvcd.getproj(idprj);
		System.out.println("s1");
		return listproj;
	}

	public boolean updateproj(Corporate1 proj) {
		System.out.println("s2");
		return mvcd.updateproj(proj);
	}
	
}
