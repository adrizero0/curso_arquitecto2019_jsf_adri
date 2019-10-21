package cookies;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.RequestCookieMap;

import managed.LoginBean;
@RequestCookieMap
public class Cookie implements CookieStore {
	@ManagedProperty("#{loginBean}")
	LoginBean loginBean;

	@Override
	public void add(URI arg0, HttpCookie arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<HttpCookie> get(URI arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HttpCookie> getCookies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<URI> getURIs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(URI arg0, HttpCookie arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll() {
		// TODO Auto-generated method stub
		return false;
	}

}
