package org.prajval.ServiceLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.prajval.EntityLayer.Voter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VoterService {

	ArrayList<Voter> list = new ArrayList<Voter>();

	/* enter candidate */
	public List<Voter> save(Voter v, String name) {
		Voter voter = new Voter();
		voter.setName(v.getName());
		list.add(voter);
		return list;
	}

	/* cast vote */
	public List<Voter> giveVote(Voter v, String name) {
		Voter voter = new Voter();
		voter.setName(name);
		list.add(voter);
		return list;
	}

	/* count vote */
	public ResponseEntity<?> countVote(String name) {
		ArrayList<String> vv = (ArrayList<String>) getVoteList().stream().map(emp -> emp.getName())
				.collect(Collectors.toList());
		vv.add(list.toString());
		Map<String, Long> mapCount = vv.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		mapCount.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey())
				.collect(Collectors.toSet());
		return new ResponseEntity<>(mapCount, HttpStatus.OK);
	}

	/* list vote */
	public ResponseEntity<?> getEachCandidateVoteCount(Voter v1) {
		ArrayList<String> vv = (ArrayList<String>) getVoteList().stream().map(emp -> emp.getName())
				.collect(Collectors.toList());

		vv.add(list.toString());

		Map<String, Long> mapCount = vv.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		mapCount.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey())
				.collect(Collectors.toSet());
		return new ResponseEntity<>(mapCount, HttpStatus.OK);
	}

	/* list vote */
	public List<Voter> getVoteList() {
		return list;
	}

	/* get winner */
	public ResponseEntity<?> Winner(Voter v2) {
		List<String> vv = getVoteList().stream().map(vt -> vt.getName()).collect(Collectors.toList());
		vv.add(list.toString());
		Map<String, Long> mapVV = vv.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Set<String> ab = mapVV.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey())
				.collect(Collectors.toSet());
		return new ResponseEntity<>(ab, HttpStatus.OK);
	}

	public void init() {

	}
}