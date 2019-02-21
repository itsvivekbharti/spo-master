package com.spo.workforce.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Work Force team object containing number of seniors and juniors
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class WorkForceTeam {
	private int senior;
	private int junior;
}
