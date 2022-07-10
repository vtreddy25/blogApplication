package com.vtr.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtr.blog.entities.User;
import com.vtr.blog.exceptions.ResourceNotFoundException;
import com.vtr.blog.payloads.UserDto;
import com.vtr.blog.repository.UserRepo;
import com.vtr.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user=this.userDtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
	       User user=this.userRepo.findById(userId)
	    		   .orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
	       
	       user.setName(userDto.getName());
	       user.setEmail(userDto.getEmail());
	       user.setPassword(userDto.getPassword());
	       user.setAbout(userDto.getAbout());
	       
	       User updatedUser=this.userRepo.save(user);
	       UserDto userDto1=this.userToUserDto(updatedUser);
	       
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user=this.userRepo.findById(userId)
	    		   .orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> listOfUsers=this.userRepo.findAll();
		List<UserDto> userDtos= listOfUsers.stream()
				.map(user->this.userToUserDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user=this.userRepo.findById(userId)
	    		   .orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		this.userRepo.delete(user);

	}
	
	private User userDtoToUser(UserDto userDto) {
		User user=this.modelMapper.map(userDto, User.class);
		
		return user;
	}
	private UserDto userToUserDto(User user) {
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getName());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;
	}
	

}
