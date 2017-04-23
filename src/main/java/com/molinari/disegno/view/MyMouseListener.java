package com.molinari.disegno.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import com.molinari.disegno.business.StarterDisegno;

public class MyMouseListener {

	MouseAdapter mouseAdapter = new MouseAdapter() {

		@Override
		public void mousePressed(final MouseEvent e) {
			StarterDisegno.mousePressed(e);
		}

		@Override
		public void mouseReleased(final MouseEvent e) {
			StarterDisegno.mouseReleased(e);
		}

		@Override
		public void mouseClicked(final MouseEvent e) {
			StarterDisegno.mouseClicked(e);
		}
	};

	MouseMotionAdapter mouseMotionAdapter = new MouseMotionAdapter() {
		@Override
		public void mouseMoved(final MouseEvent e) {
			StarterDisegno.mouseMoved(e);
		}

		@Override
		public void mouseDragged(final MouseEvent e) {
			StarterDisegno.mouseDragged(e);
		}

	};

	public MouseAdapter getMouseAdapter() {
		return mouseAdapter;
	}

	public MouseMotionAdapter getMouseMotionAdapter() {
		return mouseMotionAdapter;
	}
}
