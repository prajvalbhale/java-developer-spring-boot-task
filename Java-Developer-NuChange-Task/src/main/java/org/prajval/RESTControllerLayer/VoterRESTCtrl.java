package org.prajval.RESTControllerLayer;

import java.util.List;

import org.prajval.EntityLayer.Voter;
import org.prajval.ServiceLayer.VoterService;
import org.prajval.VoterRepositoryLayer.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoterRESTCtrl {

	@Autowired(required = false)
	VoterService voterService;

	@Autowired(required = false)
	VoterRepository vr;

	@RequestMapping(value = "/entercandidate/{name}", method = RequestMethod.POST)
	public List<Voter> addVoter(@RequestBody Voter v, @PathVariable String name) {
		return voterService.save(v, name);
	}

	@RequestMapping(value = "/castvote/{name}", method = RequestMethod.POST)
	public List<Voter> castvote(@RequestBody Voter v, @PathVariable String name) {
		return voterService.giveVote(v, name);
	}

	@RequestMapping(value = "/countvote/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> CountVote(@PathVariable String name, @RequestBody Voter v) {
		return voterService.countVote(name);
	}

	@RequestMapping(value = "/listvote", method = RequestMethod.GET)
	public ResponseEntity<?> getVoteList(@RequestBody Voter v) {
		return voterService.getEachCandidateVoteCount(v);
	}

	@RequestMapping(value = "/getwinner", method = RequestMethod.GET)
	public ResponseEntity<?> getWinner(@RequestBody Voter v2) {
		return voterService.Winner(v2);
	}
}