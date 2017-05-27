package com.vektorel.rest;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

@Path("/person")
public class PersonRest {
	Gson gson = new Gson();
	
	@GET
	@Path("/get/{param1}")
	@Produces(MediaType.APPLICATION_JSON)
	public String kullaniciGetir(@PathParam("param1") int id){
		Person person = PersonServis.getInstance().personList.get(id);
		String veri = gson.toJson(person);
		return veri;
	}
	
	@POST
	@Path("/post/")
	public Response kullaniciEkle(@FormParam("id") int id,
								@FormParam("name") String name){
		PersonServis.getInstance().personList.add(new Person(id, name));
		return Response.serverError().build();
	}
	
	@POST
	@Path("/post2/")
	public String kullaniciEkle2(@FormParam("id") int id,
								@FormParam("name") String name){
		PersonServis.getInstance().personList.add(new Person(id, name));
		return "ok";
	}
	
	@PUT
	@Path("/put/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response kullanciEklePut(String json){
		Person person = gson.fromJson(json, Person.class);
		PersonServis.getInstance().personList.add(person);
		return Response.ok("oldu").build();
	}
	
	@DELETE
	@Path("/delete/{param1}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response kullaniciSilme(@PathParam("param1") int id){
		Person person = PersonServis.getInstance().personList.remove(id);
		String veri = gson.toJson(person);
		return Response.ok(veri).build();
	}
	
	@POST
	@Path("/guncelle/{param1}")
	public Response kullaniciGuncelle(@PathParam("param1") int id,
									  @FormParam("name") String name){
		Person person = PersonServis.getInstance().personList.get(id);
		person.setName(name);
		return Response.ok().build();
	}
	
	@POST
	@Path("/toplama/")
	public Response toplama(@FormParam("veri1") int veri1,
							@FormParam("veri2") int veri2){
		String s =String.valueOf(veri1+veri2);
		return Response.ok(s).build();
	}
	
	
	
	
	

}
