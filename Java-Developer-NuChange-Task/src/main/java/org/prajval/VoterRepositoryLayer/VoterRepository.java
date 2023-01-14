package org.prajval.VoterRepositoryLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.prajval.EntityLayer.Voter;

public class VoterRepository {

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

	/* count the vote and print that */
	int maxRepeatingName(int list[], int n, int k) {
		for (int i = 0; i < n; i++)
			list[(list[i] % list.length)] += list.length;

		int max = list[0], result = 0;
		for (int i = 1; i < n; i++) {
			if (list[i] > max) {
				max = list[i];
				result = i;
			}
		}
		return result;
	}

	/* count vote */
	public List<Voter> getEachCandidateVoteCount(List<Voter> vo) {
		ArrayList<String> vv = (ArrayList<String>) getVoteList().stream().map(emp -> emp.getName())
				.collect(Collectors.toList());

		vv.add(list.toString());

		Map<String, Long> mapCount = vv.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		mapCount.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey())
				.collect(Collectors.toSet());
		return vo;
		
	}

	/* list vote */
	public List<Voter> getVoteList() {
		return list;
	}

	public static <T> List<T> convertSetToList(Set<T> set) {
		List<T> list = new ArrayList<>();
		for (T t : set)
			list.add(t);
		return list;
	}

	/* get winner */
	public List<Voter> getWinner() {
//		list = 
//		getVoteList()
//		.stream()
//		.map(v -> v.getName()).collect(Collectors.toList());
//	
//	Set<Voter> uniqu = new HashSet<>();
//	Set<Voter> MaxName = list
//			.stream()
//			.filter(names -> !uniqu.add(names)).collect(Collectors.toList());
//			//.collect(Collectors.toList())); 
//		
//			try {
//			Set<Voter> VoteCount = list.stream().filter(votec -> Collections.frequency(list, votec) > 1)
//					.collect(Collectors.toSet());
//			List<Voter> list2 = convertSetToList(VoteCount);
//			list2.addAll(VoteCount);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		return list;
	}
}