/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { MenstrualCycleComponent } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle.component';
import { MenstrualCycleService } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle.service';
import { MenstrualCycle } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle.model';

describe('Component Tests', () => {

    describe('MenstrualCycle Management Component', () => {
        let comp: MenstrualCycleComponent;
        let fixture: ComponentFixture<MenstrualCycleComponent>;
        let service: MenstrualCycleService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [MenstrualCycleComponent],
                providers: [
                    MenstrualCycleService
                ]
            })
            .overrideTemplate(MenstrualCycleComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(MenstrualCycleComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(MenstrualCycleService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new MenstrualCycle('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.menstrualCycles[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
